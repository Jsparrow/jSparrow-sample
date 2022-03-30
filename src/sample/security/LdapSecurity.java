package sample.security;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.servlet.http.HttpServletRequest;

public class LdapSecurity {
	
	/* InitialLdapContext extends 	InitialDirContext implements LdapContext
	 * 								InitialDirContext extends InitialContext implements DirContext
	 * 
	 * 
	 */
	
	public void importLdapSecurity(InitialLdapContext context) throws NamingException {
		
		Name name = null;
		String filter = "";
		SearchControls cons = null;
		context.search(name, filter, cons);
	}
	
	
	public boolean authenticate(HttpServletRequest request, DirContext ctx) throws NamingException {
	    String user = request.getParameter("user");
	    String pass = request.getParameter("pass");

	    String filter = "(&(uid=" + user + ")(userPassword=" + pass + "))";
	    NamingEnumeration<SearchResult> results = ctx.search("ou=system", filter, new SearchControls());
	    return results.hasMore();
	}
	
	public boolean authenticate_safe(javax.servlet.http.HttpServletRequest request, DirContext ctx) throws NamingException {
	    String user = request.getParameter("user");
	    String pass = request.getParameter("pass");
	    String filter = "(&(uid={0})(userPassword={1}))"; // Safe

	    NamingEnumeration<SearchResult> results = ctx.search("ou=system", filter, new String[] {user, pass}, new SearchControls());
	    return results.hasMore();
	}
	
	private DirContext getContext() throws NamingException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, "http://ldaptest.splendit.loc:8084/");

		return new InitialDirContext(properties);
	}
	
	
	

}
