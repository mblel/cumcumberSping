package serviceimpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import model.Abonne;
import service.IAbonneService;

@Service
@Transactional
public class AbonneServiceImpl implements IAbonneService {

	@Override
	public void modifAbonneAdresse(Abonne abonne, String adresse) {
		abonne.getAdresse().setAdr(adresse);
	}

}
