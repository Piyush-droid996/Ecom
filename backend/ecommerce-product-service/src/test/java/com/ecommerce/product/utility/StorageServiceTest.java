package com.ecommerce.product.utility;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

class StorageServiceTest {

    @Mock
    private StorageService storageService;

    @Mock
    private MultipartFile file;

    @Mock
    private Resource resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadAll() {
        // Arrange
        List<String> fileList = Arrays.asList("file1.txt", "file2.jpg", "file3.png");
        when(storageService.loadAll()).thenReturn(fileList);

        // Act
        List<String> result = storageService.loadAll();

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("file1.txt", result.get(0));
        verify(storageService, times(1)).loadAll();
    }

    @Test
    void testStore() {
        // Arrange
        when(file.getOriginalFilename()).thenReturn("testFile.txt");
        when(storageService.store(file)).thenReturn("storedFileName.txt");

        // Act
        String storedFileName = storageService.store(file);

        // Assert
        assertNotNull(storedFileName);
        assertEquals("storedFileName.txt", storedFileName);
        verify(storageService, times(1)).store(file);
    }

    @Test
    void testLoad() {
        // Arrange
        String fileName = "testFile.txt";
        when(storageService.load(fileName)).thenReturn(resource);

        // Act
        Resource loadedResource = storageService.load(fileName);

        // Assert
        assertNotNull(loadedResource);
        verify(storageService, times(1)).load(fileName);
    }

    @Test
    void testDelete() {
        // Arrange
        String fileName = "fileToDelete.txt";

        // Act
        storageService.delete(fileName);

        // Assert
        verify(storageService, times(1)).delete(fileName);
    }
}
