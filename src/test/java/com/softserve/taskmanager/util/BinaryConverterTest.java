package com.softserve.taskmanager.util;

import com.softServe.taskManager.controller.LoginController;
import com.softServe.taskManager.model.User;
import com.softServe.taskManager.util.converters.impl.BinaryConverter;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-test.xml")
public class BinaryConverterTest {

    public static final String FILE_PATH = "file.bin";
    @InjectMocks
    private BinaryConverter binaryConverter;
    @Rule
    public TemporaryFolder tempFolder;

    @Before
    public void setUp() throws Exception {
        this.tempFolder = new TemporaryFolder();
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        tempFolder.delete();
    }

    @Test
    public void testConvertDeconvert() throws IOException {
        User expected = new User();
        expected.setEmail("admin@admin.com");
        expected.setPassword("sdf");
        tempFolder.create();
        File file = tempFolder.newFile(FILE_PATH);
        binaryConverter.convert(expected, file.getPath());
        User actual = (User) binaryConverter.deconvert(file.getPath());
        assertEquals(expected, actual);
    }
}
