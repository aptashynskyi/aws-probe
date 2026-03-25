package edu.aptashynskyi.aws.probe;

import org.springframework.boot.SpringApplication;

public class TestAwsProbeApplication
{

    public static void main( String[] args )
    {
        SpringApplication.from( AwsProbeApplication::main ).with( TestcontainersConfiguration.class ).run( args );
    }

}
