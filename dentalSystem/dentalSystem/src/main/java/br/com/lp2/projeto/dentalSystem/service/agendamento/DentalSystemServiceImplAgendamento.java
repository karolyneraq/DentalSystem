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
    public List<AgendamentoDTO> list() {
        List<AgendamentoDTO> response = new ArrayList<>();
        AgendamentoDTO agendamento;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
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
    public Boolean add(AgendamentoDTO agendamento) {
        Map<String, Object> docData = getDocData(agendamento);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

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
    public Boolean edit(String id, AgendamentoDTO agendamento) {
        Map<String, Object> docData = getDocData(agendamento);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
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
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("agendamento");
    }

    private Map<String, Object> getDocData(AgendamentoDTO agendamento) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("medico", agendamento.getNomeMedico());
        docData.put("data", agendamento.getData());
        docData.put("horario", agendamento.getHorario());
        docData.put("obs", agendamento.getObs());
        return docData;
    }
}
