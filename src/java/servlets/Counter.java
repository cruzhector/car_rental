/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

class CounterException extends ServletException {
    public CounterException(String message) {
  super(message);
    }
}

             
public class Counter extends HttpServlet {

    private final String file_path = "D:/projects/Netbeans/swift/visited.txt";
    File file_name = new File(file_path); 
    private final String cookie_name = "userVisited";
    private final String cookie_value = "visited";

    private String getCookieValue(HttpServletRequest request, String name) throws CounterException
    {
  Cookie cookies[] = request.getCookies();
  Cookie cookie;

  if (cookies == null)
      throw new CounterException("No cookies have been set");
  
        for (Cookie cookie1 : cookies) {
            cookie = cookie1;
            if (cookie.getName().equals(name))
                return cookie.getValue();
        }

  throw new CounterException("Unable to find a cookie named " +
           name);
    }   
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  BufferedReader file = null;
  int count = 0;

  synchronized (this) {
      try {
    file = new BufferedReader(new FileReader(file_name));    
                String st, counts = ""; 
                while ((st = file.readLine()) != null) {
                  counts = st;
                } 
                count = Integer.parseInt(counts);
      }
      catch(IOException e) {
      }
      finally {
    try {
        if (file != null)
      file.close();
    }
    catch (IOException b) {}
      }


      String value = null;
      try {
    value = getCookieValue(request, cookie_name);
      }
      catch(CounterException e) {
    Cookie cookie = new Cookie(cookie_name, cookie_value);
    cookie.setMaxAge(60 * 60 * 24);
    response.addCookie(cookie);
    count ++;    
      }
  

      PrintWriter writer = null;
      try  {
    writer = new PrintWriter(new FileWriter(file_name));
    writer.print(count);
    writer.close();
    writer = null;
      }
      catch (IOException e) {
      }
      finally {
    if (writer != null)
        writer.close();
      }
            
            try {   
                PrintWriter out = response.getWriter();                
                out.println(count);
            }
            catch (IOException e) {
            }
  }                
    }
}