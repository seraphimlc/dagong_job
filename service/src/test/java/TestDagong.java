import com.dagong.job.JobClient;
import com.dagong.pojo.Company;
import com.dagong.pojo.JobType;
import com.dagong.service.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 16/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/resources/base/all.xml")
public class TestDagong {
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;

//    @Autowired
//    private JobClient jobClient;
    @Autowired
    private SearchService searchService;

    private Map<String, JobType> jobTypeMap = new HashMap<>();

    private Map<String, Company> companyMap = new HashMap<>();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

//   @Test
//    public void test(){
//       System.out.println("jobClient = " + jobClient);
//    }
//
//    @Test
//    public void testSearchJob() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/job/forUser.do").cookie(new Cookie("user", "123")))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print()).andReturn();
//
//    }
@Test
    public void testSearchJob(){
        int[] jobs= new int[]{52,53};
//        List<Map> maps = searchService.searchJobByType(jobs, 1);
//        maps.forEach(map -> {
//            map.forEach((key,value)->{
//                System.out.println("key = " + key);
//                System.out.println("value = " + value);
//                System.out.println("----------------");
//            });
//        });

    }


}
