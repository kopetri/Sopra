package management;

import java.util.List;

public class User {

    //
    private String login;
    private String firstName;
    private String lastName;
    private String mail;
    private Boolean[] rights;
    private String session;
    private String faculty;
    private List<String> institute;
    private String representative;
    private String supervisor;


    public User(String login, String firstName, String lastName, String mail,
	    Boolean[] rights, String session, String faculty,
	    List<String> institute, String representative, String supervisor) {

	super();
	this.login = login;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mail = mail;
	this.rights = rights;
	this.session = session;
	this.faculty = faculty;
	this.institute = institute;
	this.representative = representative;
	this.supervisor = supervisor;
    }


    /**
     * @return the login
     */
    public String getLogin() {

	return login;
    }


    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {

	this.login = login;
    }


    /**
     * @return the firstName
     */
    public String getFirstName() {

	return firstName;
    }


    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {

	this.firstName = firstName;
    }


    /**
     * @return the lastName
     */
    public String getLastName() {

	return lastName;
    }


    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {

	this.lastName = lastName;
    }


    /**
     * @return the mail
     */
    public String getMail() {

	return mail;
    }


    /**
     * @param mail
     *            the mail to set
     */
    public void setMail(String mail) {

	this.mail = mail;
    }


    /**
     * @return the rights
     */
    public Boolean[] getRights() {

	return rights;
    }


    /**
     * @param rights
     *            the rights to set
     */
    public void setRights(Boolean[] rights) {

	this.rights = rights;
    }


    /**
     * @return the session
     */
    public String getSession() {

	return session;
    }


    /**
     * @param session
     *            the session to set
     */
    public void setSession(String session) {

	this.session = session;
    }


    /**
     * @return the faculty
     */
    public String getFaculty() {

	return faculty;
    }


    /**
     * @param faculty
     *            the faculty to set
     */
    public void setFaculty(String faculty) {

	this.faculty = faculty;
    }


    /**
     * @return the institute
     */
    public List<String> getInstitute() {

	return institute;
    }


    /**
     * @param institute
     *            the institute to set
     */
    public void setInstitute(List<String> institute) {

	this.institute = institute;
    }


    /**
     * @return the representative
     */
    public String getRepresentative() {

	return representative;
    }


    /**
     * @param representative
     *            the representative to set
     */
    public void setRepresentative(String representative) {

	this.representative = representative;
    }


    /**
     * @return the supervisor
     */
    public String getSupervisor() {

	return supervisor;
    }


    /**
     * @param supervisor
     *            the supervisor to set
     */
    public void setSupervisor(String supervisor) {

	this.supervisor = supervisor;
    }
}
