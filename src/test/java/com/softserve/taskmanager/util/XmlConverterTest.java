package com.softserve.taskmanager.util;

import com.softServe.taskManager.model.User;
import com.softServe.taskManager.util.converters.impl.BinaryConverter;
import com.softServe.taskManager.util.converters.impl.XmlConverter;
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

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-test.xml")
public class XmlConverterTest {

    public static final String FILE_PATH = "file.xml";
    @InjectMocks
    private XmlConverter xmlConverter;
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
        xmlConverter.convert(expected, file.getPath());
        User actual = (User) xmlConverter.deconvert(file.getPath());
        assertEquals(expected, actual);
    }
}