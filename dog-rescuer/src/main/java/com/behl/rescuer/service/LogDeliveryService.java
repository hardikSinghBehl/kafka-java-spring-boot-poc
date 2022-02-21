package com.behl.rescuer.service;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDeliveryService implements ListenableFutureCallback<SendResult<Null, String>> {

	@Override
	public void onSuccess(SendResult<Null, String> result) {
		final var recordMetadata = result.getRecordMetadata();
		final var deliveredDog = result.getProducerRecord().value();
		log.info("Delivered {} as offset {} to partition {}", deliveredDog, recordMetadata.offset(),
				recordMetadata.partition());
	}

	@Override
	public void onFailure(Throwable exeption) {
		log.error("Unable to deliver Dog: ", exeption);
	}
}
