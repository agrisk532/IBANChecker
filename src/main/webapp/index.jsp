<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
    <head> 
        <title>IBAN verificator</title>
    </head> 
    <body bgcolor="#ffffcc">
    <h3>Verify IBAN</h3>
        <form action="main.jsp" method="get">
            <TABLE style="background-color: #ECE5B6; width: 100px">
                <tr>
					<td width="25%"><input type="radio" name="selector" 
                        value="single" checked="checked">Single</td>
                </tr>
                 <tr>
					<td width="25%"><input type="radio" name="selector" 
                        value="list">List</td>
                </tr>
				<tr>
				<td width="25%"><input type="submit" name="submit" value="Select"></td>
				</tr>
            </TABLE>
        </form>
    </body> 
</html>