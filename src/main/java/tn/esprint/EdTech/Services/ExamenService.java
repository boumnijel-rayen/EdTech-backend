package tn.esprint.EdTech.Services;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprint.EdTech.Entities.Examen;
import tn.esprint.EdTech.Repositories.ExamenRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamenService implements IExamenService{
    @Autowired
    private ExamenRepo examenRepository;
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;



    @Override
    public List<Examen> getAllExams() {
        return examenRepository.findAll();
    }
    @Override
    public Optional<Examen> getExamById(Long id) {
        return examenRepository.findById(id);
    }

    @Override
    public List<Examen> getExamsByMatiereId(Long matiereId) {
        return examenRepository.findByMatiereId(matiereId);
    }

    @Override
    public Examen createExam(Examen examen) {
        return examenRepository.save(examen);
    }
    @Override
    public Examen updateExam(Long id, Examen examenDetails) {
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + id));


            examen.setNote(examenDetails.getNote());

        if (examenDetails.getEnonce() != null) {
            examen.setEnonce(examenDetails.getEnonce());
        }
        if (examenDetails.getTravail() != null) {
            examen.setTravail(examenDetails.getTravail());
        }
        if (examenDetails.getEtudiant() != null) {
            examen.setEtudiant(examenDetails.getEtudiant());
        }
        if (examenDetails.getMatiere() != null) {
            examen.setMatiere(examenDetails.getMatiere());
        }

        return examenRepository.save(examen);
    }
@Override
    public void deleteExam(Long id) {
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + id));
        examenRepository.delete(examen);
    }

    @Override
    public Examen uploadFile(Long examenId, MultipartFile file) throws IOException {
        Examen examen = examenRepository.findById(examenId)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + examenId));

        String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(filename)
                            .stream(inputStream, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file to Minio", e);
        }

        examen.setTravail(filename);
        return examenRepository.save(examen);
    }


@Override
    public String getDownloadLink(Long examenId) {
        Examen examen = examenRepository.findById(examenId)
                .orElseThrow(() -> new RuntimeException("Examen not found with id " + examenId));

        String objectName = examen.getEnonce();

        try {
            StatObjectResponse stat = minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build()
            );

            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .method(Method.GET)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error getting download link from Minio", e);
        }
    }

}





