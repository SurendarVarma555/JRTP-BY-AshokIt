package in.ashokit.service;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReportService {

    public List<String> getUniquePlanNames ();

    public List<String> getUniquePlanStatuses ();

    public List<SearchResponse> search (SearchRequest request);


    public void generateExcel (HttpServletResponse response) throws Exception;

    public void generatePdf (HttpServletResponse response) throws Exception;


}