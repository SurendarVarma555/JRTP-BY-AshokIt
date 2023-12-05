package in.ashokit.controller;

import in.ashokit.bindings.CoInfo;
import in.ashokit.service.CoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/co")
public class CoController {

    @Autowired
    private CoService coService;

    @GetMapping("/notices/{caseNum}/{status}")
    public ResponseEntity<List<CoInfo>> getNotices (@PathVariable Integer caseNum, @PathVariable String status){
        List<CoInfo> notices = coService.getNotices(caseNum, status);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    @GetMapping("/printNotice/{noticeId}")
    public ResponseEntity<String> printNotice (@PathVariable Integer noticeId){
        boolean result = coService.printNotice(noticeId);
        if (result) {
            return new ResponseEntity<>("Notice printed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to print notice", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
