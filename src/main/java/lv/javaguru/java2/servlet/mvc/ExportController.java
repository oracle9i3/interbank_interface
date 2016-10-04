package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.servlet.CustomerListForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.servlet.view.UrlBasedViewResolver.FORWARD_URL_PREFIX;


/**
 * Created by Svetlana Titova on 03.10.2016.
 */
@Controller
@RequestMapping("/customersExport")
public class ExportController {

    @Resource
    private HttpServletRequest request;

    private Logger LOG = LoggerFactory.getLogger(ExportController.class);

    private String listToString(List<String> l) {

        String out = "";
        Iterator<String> i = l.iterator();
        while (i.hasNext()) {
            out += ",\n" + i.next();
        }
        if ("".equals(out)) {
            return out;
        }

        return out.substring(1);
    }

    @RequestMapping
    public String showForm(@ModelAttribute("customerListForm")CustomerListForm form){

        String checked[]=form.getChecked();
        String exportCommand=form.getExportCommand();
        List<String> aList = new ArrayList<>(0);

        int selectedSize=0;
        if(checked!=null){
            for (String ch : checked) {
                String[] sp = ch.split("->");
                if (sp[1]!=null){
                    String cust_id = sp[0];
                    LOG.debug("Splitting checked list "+cust_id);
                    selectedSize++;


                    aList.add(cust_id);

                }
            }
        }
        if(selectedSize<1){
            LOG.debug("No customers selected");
        }
        else {
            if("customersExport".equalsIgnoreCase(exportCommand)){
                exportCustomersSelected(aList, selectedSize);
            }

        }


        return forwardedServletRelative("/customerList");
    }



  private void exportCustomersSelected (List<String> ids , int selectedSize)  {

CustomerExportResult result = CustomerExportComponent.export(ids);

  }


protected String forwardedServletRelative(String url){
    StringBuilder sb = new StringBuilder(FORWARD_URL_PREFIX);
    if (url.startsWith("/")){
       sb.append(request.getServletPath());
    }
    sb.append(url);
    return sb.toString();
}

}
