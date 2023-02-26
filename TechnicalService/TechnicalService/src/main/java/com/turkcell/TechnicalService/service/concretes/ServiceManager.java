package com.turkcell.TechnicalService.service.concretes;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.dao.ServiceDao;
import com.turkcell.TechnicalService.service.abstracts.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ServiceManager implements ServiceService{

	private final ServiceDao serviceDao;
	private final MessageSource messageSource;

	@Override
	public com.turkcell.TechnicalService.model.Service getByIdAsService(long bookingServiceId,Locale locale) {
		checkServiceIdExists(bookingServiceId,locale);		
		return serviceDao.findById(bookingServiceId).get();
	}

	private void checkServiceIdExists(long bookingServiceId, Locale locale) {
		if(!serviceDao.existsById(bookingServiceId)) {
			throw new BusinessException(messageSource.getMessage("service.checkserviceidexists.error", new Object[] {bookingServiceId}, locale));
		}
		
	}
	
	
}
