package org.primefaces.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "testView")
@ViewScoped
public class TestView implements Serializable {

    private String testString;

    private String mediaId;

    @PostConstruct
    public void init() {
        testString = "Welcome to PrimeFaces!!!";
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public static String getDownloadURL(String urlStr) {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String url = req.getRequestURL().toString();
        String exportContent = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath()
                + "/" + urlStr;
        return exportContent;
    }

    public void showImage() {
        mediaId = getDownloadURL("images/logo.png");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
