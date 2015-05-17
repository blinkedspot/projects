/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.web.servlets;

import com.registry.web.vo.fileUploader.FileMeta;
import com.registry.web.vo.fileUploader.MultipartRequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author MAQIB
 */
public class AN_UploadFilesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // this will store uploaded files
    private static List<FileMeta> files = new LinkedList<FileMeta>();
    /***************************************************
     * URL: /upload
     * doPost(): upload the files and other parameters
     ****************************************************/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
 
        System.out.println("Uploading Files"); 
        // 1. Upload File Using Java Servlet API
        //files.addAll(MultipartRequestHandler.uploadByJavaServletAPI(request));            
 
        // 2. Upload File Using Apache FileUpload
        files.addAll(MultipartRequestHandler.uploadByApacheFileUpload(request));
 
        // Remove some files
        while(files.size() > 20)
        {
            files.remove(0);
        }
 
        // 2. Set response type to json
        response.setContentType("application/json");
 
        // 3. Convert List<FileMeta> into JSON format
        ObjectMapper mapper = new ObjectMapper();
 
        // 4. Send result to client
        mapper.writeValue(response.getOutputStream(), files);
 
        System.out.println("Files uploaded successfully");
    }
    /***************************************************
     * URL: /upload?f=value
     * doGet(): get file of index "f" from List<FileMeta> as an attachment
     ****************************************************/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
 
         // 1. Get f from URL upload?f="?"
         String value = request.getParameter("f");
 
         // 2. Get the file of index "f" from the list "files"
         FileMeta getFile = files.get(Integer.parseInt(value));
 
         try {        
                 // 3. Set the response content type = file content type
                 response.setContentType(getFile.getFileType());
 
                 // 4. Set header Content-disposition
                 response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
 
                 // 5. Copy file inputstream to response outputstream
                InputStream input = getFile.getContent();
                OutputStream output = response.getOutputStream();
                byte[] buffer = new byte[1024*10];
 
                for (int length = 0; (length = input.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }
 
                output.close();
                input.close();
         }catch (IOException e) {
                e.printStackTrace();
         }
 
    }
    @Override
    public String getServletInfo() {
        return "Upload Servlet Files";
    }
}
