package com.turkcell.TechnicalService.service.abstracts;

import java.util.Locale;

import com.turkcell.TechnicalService.model.Service;

public interface ServiceService {

	Service getByIdAsService(long bookingServiceId,Locale locale);

}
