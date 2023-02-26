package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.model.Service;

import java.util.Locale;

public interface ServiceService {

	Service getByIdAsService(long bookingServiceId,Locale locale);

}
