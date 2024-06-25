package com.viracam.backend.services.category;

import com.viracam.backend.model.Category;
import com.viracam.backend.repository.category.CategoryRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Category category1 = new Category();
        category1.setCode("code1");
        Category category2 = new Category();
        category2.setCode("code2");

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        Iterable<Category> result = categoryService.findAll();

        assertNotNull(result);
        assertEquals(2, ((Collection)result).size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void testAddCategory() {
        Category category = new Category();
        category.setCode("code");

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Category result = categoryService.addCategory(category);

        assertNotNull(result);
        assertEquals("code", result.getCode());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    public void testGetByCategoryCode() {
        Category category = new Category();
        category.setCode("code");

        when(categoryRepository.findByCode("code")).thenReturn(category);

        Category result = categoryService.getByCategoryCode("code");

        assertNotNull(result);
        assertEquals("code", result.getCode());
        verify(categoryRepository, times(1)).findByCode("code");
    }

    @Test
    public void testFindByCode() {
        Category category = new Category();
        category.setCode("code");

        when(categoryRepository.findByCode("code")).thenReturn(category);

        Category result = categoryService.findByCode("code");

        assertNotNull(result);
        assertEquals("code", result.getCode());
        verify(categoryRepository, times(1)).findByCode("code");
    }
}
