package de.pecko.ruediger;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Object;

public class S3Connection {

	private static S3Client client;

	public S3Connection() {
		AwsCredentials credentials = AwsBasicCredentials.create("XXX",
				"XXX");

		client = S3Client.builder().region(Region.EU_CENTRAL_1)
				.credentialsProvider(StaticCredentialsProvider.create(credentials))
				.endpointOverride(URI.create("https://s3.eu-central-1.amazonaws.com")).forcePathStyle(true).build();
	}

	public List<String> listBucketObjects(String bucketName, String objectPrefix) {
		try {
			ListObjectsRequest listObjects = ListObjectsRequest.builder().bucket(bucketName).prefix(objectPrefix)
					.build();

			ListObjectsResponse res = client.listObjects(listObjects);
			List<S3Object> objects = res.contents();
			return objects.stream().map(v -> v.key().replaceFirst("sounds/", "")).skip(1).sorted().toList();

		} catch (S3Exception e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}
		return Collections.emptyList();
	}

}
