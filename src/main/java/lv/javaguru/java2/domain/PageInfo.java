package lv.javaguru.java2.domain;

/**
 * Created by Svetlana Titova on 12.09.2016.
 */
public class PageInfo {
    private String _firstPage;
    private String _lastPage;
    private String _nextPage;
    private String _prevPage;
    private String _currentPage;

    public String getFirstPageURI(){ return _firstPage; }

    public String getNextPageURI() {
        return _nextPage;
    }

    public String getCurrentPage() {
        return _currentPage;
    }

    public String getPrevPageURI() {
        return _prevPage;
    }

    public String getLastPageURI() { return _lastPage; }

    public PageInfo(String firstPageURI,String lastPageURI ,String nextPageURI,String prevPageURI, String currentPage) {

        _firstPage = firstPageURI;
        _lastPage = lastPageURI;
        _nextPage = nextPageURI;
        _prevPage = prevPageURI;
        _currentPage=currentPage;
    }
}
