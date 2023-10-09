package com.programmers.urlshortener.domain.encoder.domain;

import java.util.Arrays;
import java.util.Objects;

public enum EncoderType {
	BASE62("base62Encoder"),
	RANDOM("randomEncoder");

	String encoderName;

	EncoderType(String encoderName) {
		this.encoderName = encoderName;
	}

	@Override
	public String toString() {
		return encoderName;
	}

	public static EncoderType findEncoderType(String requestEncoderType) {

		return Arrays.stream(EncoderType.values())
			.filter(encoderType -> Objects.equals(encoderType.name(), requestEncoderType))
			.findAny()
			.orElseThrow(() -> new RuntimeException());
	}
}
