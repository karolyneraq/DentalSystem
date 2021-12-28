package br.com.lp2.projeto.dentalSystem.service.notificacoes.notificacao;

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

import br.com.lp2.projeto.dentalSystem.dto.NotificacaoDTO;
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplNotificacao implements DentalSystemServiceNotificacao {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<NotificacaoDTO> list() {
        List<NotificacaoDTO> response = new ArrayList<>();
        NotificacaoDTO msg;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
            	msg = doc.toObject(NotificacaoDTO.class);
                msg.setId(doc.getId());
                response.add(msg);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(NotificacaoDTO msg) {
        Map<String, Object> docData = getDocData(msg);

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
    public Boolean edit(String id,NotificacaoDTO msg) {
        Map<String, Object> docData = getDocData(msg);
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
        return firebase.getFirestore().collection("notificacao");
    }

    private Map<String, Object> getDocData(NotificacaoDTO msg) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("nomePaciente", msg.getNomePaciente());
        docData.put("msg", msg.getMsg());
        docData.put("nomeMedico", msg.getNomeMedico());
        return docData;
    }
}
