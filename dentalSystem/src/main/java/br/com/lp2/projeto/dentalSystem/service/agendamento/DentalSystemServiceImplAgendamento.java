package br.com.lp2.projeto.dentalSystem.service.agendamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import br.com.lp2.projeto.dentalSystem.dto.AgendamentoDTO;
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplAgendamento implements DentalSystemServiceAgendamento {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<AgendamentoDTO> list(String idPaciente) {
        List<AgendamentoDTO> response = new ArrayList<>();
        AgendamentoDTO agendamento;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection(idPaciente).get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
            	agendamento = doc.toObject(AgendamentoDTO.class);
                agendamento.setId(doc.getId());
                response.add(agendamento);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(String idPaciente,AgendamentoDTO agendamento) {
        Map<String, Object> docData = getDocData(agendamento);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection(idPaciente).document().create(docData);

        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }


    @Override
    public Boolean edit(String idPaciente, String id,AgendamentoDTO agendamento) {
        Map<String, Object> docData = getDocData(agendamento);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection(idPaciente).document(id).set(docData);
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String idPaciente, String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection(idPaciente).document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection(String idP) {
        return firebase.getFirestore().collection("paciente").document(idP).collection("agendamento");
    }

    private Map<String, Object> getDocData(AgendamentoDTO agendamento) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("data", agendamento.getData());
        docData.put("horario", agendamento.getHorario());
        docData.put("obs", agendamento.getObs());
        docData.put("idPaciente", agendamento.getIdPaciente());
        docData.put("nomePaciente", agendamento.getNomePaciente());
        docData.put("idMedico", agendamento.getIdMedico());
        docData.put("nomeMedico", agendamento.getNomeMedico());
        return docData;
    }
}
