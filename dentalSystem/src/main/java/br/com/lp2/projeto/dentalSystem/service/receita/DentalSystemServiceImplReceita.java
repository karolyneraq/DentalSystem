package br.com.lp2.projeto.dentalSystem.service.receita;

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

import br.com.lp2.projeto.dentalSystem.dto.ReceitaDTO;
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplReceita implements DentalSystemServiceReceita {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<ReceitaDTO> list(String idPaciente) {
        List<ReceitaDTO> response = new ArrayList<>();
        ReceitaDTO receita;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection(idPaciente).get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
            	receita = doc.toObject(ReceitaDTO.class);
            	receita.setId(doc.getId());
                response.add(receita);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(String idPaciente,ReceitaDTO receita) {
        Map<String, Object> docData = getDocData(receita);

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
    public Boolean edit(String idPaciente, String id,ReceitaDTO receita) {
        Map<String, Object> docData = getDocData(receita);
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

    private Map<String, Object> getDocData(ReceitaDTO receita) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("data", receita.getData());
        docData.put("medicamento", receita.getMedicamento());
        docData.put("quantidade",  receita.getQuantidade());
        docData.put("medida", receita.getIdMedico());
        docData.put("prescricao", receita.getPrescricao());
        docData.put("idPaciente", receita.getIdPaciente());
        docData.put("idMedico", receita.getIdMedico());
        return docData;
    }
}
