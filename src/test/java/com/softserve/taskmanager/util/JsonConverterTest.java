package com.softserve.taskmanager.util;


import com.softServe.taskManager.model.User;
import com.softServe.taskManager.util.converters.impl.BinaryConverter;
import com.softServe.taskManager.util.converters.impl.JsonConverter;
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
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-test.xml")
public class JsonConverterTest {

    public static final String FILE_PATH = "file.json";
    @InjectMocks
    private JsonConverter jsonConverter;
    @Rule
    public TemporaryFolder tempFolder;

    @Before
    public void setUp() throws Exception {
        this.jsonConverter = new JsonConverter(User.class);
        this.tempFolder = new TemporaryFolder();
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        tempFolder.delete();
    }

    @Test
    public void testConvertDeconvert() throws IOException {
        User user = new User();
        ArrayList<User> expected = new ArrayList<>();
        user.setEmail("admin@admin.com");
        user.setPassword("sdf");
        expected.add(user);
        tempFolder.create();
        File file = tempFolder.newFile(FILE_PATH);
        jsonConverter.convert(expected, file.getPath());
        List actual = (List) jsonConverter.deconvert(file.getPath());
        assertEquals(expected, actual);
    }
}
