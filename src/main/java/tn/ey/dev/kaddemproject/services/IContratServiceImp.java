package tn.ey.dev.kaddemproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.ey.dev.kaddemproject.entities.Contrat;
import tn.ey.dev.kaddemproject.entities.Etudiant;
import tn.ey.dev.kaddemproject.repositories.ContratRepository;
import tn.ey.dev.kaddemproject.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class IContratServiceImp implements IContratServices {

    //@Autowired
    private ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public void ajouterContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public void updateContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getByIdContrat(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Assert.notNull(etudiant,"Etudiant not find");

        if (etudiant == null || etudiant.getContrats().size() >= 5){

        }
        ce.setEtudiant(etudiant);
        return contratRepository.save(ce);
    }

    @Override
    public Map<String, Float> getMontantContratEntreDeuxDate(Integer idUniversite, LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return contratRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * * ")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contratsPresqueExp=contratRepository.datePresqueExp();
        List<Contrat> contratsExp=contratRepository.dateExpi();

        for (Contrat c : contratsExp) {
            setArchive(c);
        }

        StringBuilder string = new StringBuilder("contrats expirants dans les 15 jours suivants :");
        for (Contrat c : contratsPresqueExp){
            string.append("contrat id : ").append(c.getIdContrat()).append("\n");
            string.append("contrat debut date : ").append(c.getDateDebutContrat()).append("\n");
            string.append("contrat date fin : ").append(c.getDateFinContrat()).append("\n");
            string.append("specialité : ").append(c.getSpecialite()).append("\n");
        }
        log.info(string.toString());
    }

    public void setArchive(Contrat c){
        Contrat contrat = contratRepository.findById(c.getIdContrat()).get();
        contrat.setArchive(true);
        contratRepository.save(contrat);

    }
}
