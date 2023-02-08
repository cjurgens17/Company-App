package com.personPractice.services;


import com.personPractice.models.Employee;
import com.personPractice.models.Image;
import com.personPractice.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }




    @Override
    public Set<Image> findAll() {

        Set<Image> images = new HashSet<>();

        imageRepository.findAll().forEach(images::add);

        return images;
    }

    @Override
    public Image findById(Long aLong) {
        return imageRepository.findById(aLong).orElse(null);
    }

    @Override
    public Image save(Image object) {
        return imageRepository.save(object);
    }

    @Override
    public void delete(Image object) {
        imageRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        imageRepository.deleteById(aLong);
    }

    @Override
    public String encodeImage(String imagePath) {
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            return Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            return null;
        }
    }
}
