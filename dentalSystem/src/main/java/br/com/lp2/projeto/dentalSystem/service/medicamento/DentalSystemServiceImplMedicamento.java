package br.com.lp2.projeto.dentalSystem.service.medicamento;

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

import br.com.lp2.projeto.dentalSystem.dto.DentistaDTO;
import br.com.lp2.projeto.dentalSystem.dto.MedicamentoDTO;
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplMedicamento implements DentalSystemServiceMedicamento {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<MedicamentoDTO> list() {
        List<MedicamentoDTO> response = new ArrayList<>();
        MedicamentoDTO medicamento;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
            	medicamento = doc.toObject(MedicamentoDTO.class);
            	medicamento.setId(doc.getId());
                response.add(medicamento);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(MedicamentoDTO medicamento) {
        Map<String, Object> docData = getDocData(medicamento);

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
    public Boolean edit(String id, MedicamentoDTO medicamento) {
        Map<String, Object> docData = getDocData(medicamento);
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
        return firebase.getFirestore().collection("medicamento");
    }

    private Map<String, Object> getDocData(MedicamentoDTO medicamento) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("nome", medicamento.getNome());
        docData.put("tipo", medicamento.getTipo());
        docData.put("medida", medicamento.getMedida());
        docData.put("posologia", medicamento.getPosologia());
        docData.put("receitaControlada", medicamento.getReceitaControlada());
        return docData;
    }
}