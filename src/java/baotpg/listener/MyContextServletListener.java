/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.listener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Admin
 */
public class MyContextServletListener implements ServletContextListener {

    private final String PATH = "/WEB-INF/properties.properties";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String path = context.getRealPath("/");
        Map<String, String> siteMap = readFile(context, path + PATH);
        context.setAttribute("SITE_MAP", siteMap);
    }

    private Map<String, String> readFile(ServletContext context, String filePath) {
        Map<String, String> siteMap = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            while (br.ready()) {
                String data = br.readLine();
                String[] getStringValue = data.split("=");
                if (getStringValue.length == 2) {
                    if (siteMap == null) {
                        siteMap = new HashMap<>();
                    }
                    String key = getStringValue[0];
                    String value = getStringValue[1];
                    siteMap.put(key, value);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return siteMap;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
