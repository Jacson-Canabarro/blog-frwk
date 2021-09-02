package br.com.frwk.requests;

import lombok.Data;

@Data
public class ImageRequestBody {

    private byte[] content;

    private String name;
}
