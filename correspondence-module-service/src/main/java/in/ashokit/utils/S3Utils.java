package in.ashokit.utils;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class S3Utils {

    @Value("$(bucketName)")
    private String bucketName;

    private final AmazonS3 s3;

    public S3Utils (AmazonS3 s3){
        this.s3 = s3;
    }

    public String uploadObject (File file){
        s3.putObject(bucketName, file.getName(), file);
        URL url = s3.getUrl(bucketName, file.getName());
        return url.toExternalForm();
    }
}
