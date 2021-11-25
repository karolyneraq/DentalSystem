package br.com.lp2.projeto.dentalSystem.service.dentista;

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
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplDentista implements DentalSystemServiceDentista {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<DentistaDTO> list() {
        List<DentistaDTO> response = new ArrayList<>();
        DentistaDTO medico;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                medico = doc.toObject(DentistaDTO.class);
                medico.setId(doc.getId());
                response.add(medico);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(DentistaDTO medico) {
        Map<String, Object> docData = getDocData(medico);

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
    public int buscarID(String id) {
    	boolean verificar;
    	int achou=0;
    	if(list().size() != 0) {
	    	for(int i=0; i<list().size(); i++) {
	    		verificar = list().get(i).getId().contains(id);
	    		if(verificar==true) {
	    			achou=i;
	    		}
	    	}
    	}
    	return achou;
    }

    @Override
    public String buscarIDPorNome(String nome) {
    	boolean verificar;
    	String achou=null;
    	if(list().size() != 0) {
	    	for(int i=0; i<list().size(); i++) {
	    		verificar = list().get(i).getNome().toLowerCase().contains(nome.toLowerCase());
	    		if(verificar==true) {
	    			achou =list().get(i).getId();
	    		}
	    	}
    	}
    	return achou;
    } 

    @Override
    public Boolean edit(String id, DentistaDTO medico) {
        Map<String, Object> docData = getDocData(medico);
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
        return firebase.getFirestore().collection("dentista"); //.collection("clinica_Login").document(). 
    }

    private Map<String, Object> getDocData(DentistaDTO medico) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("nome", medico.getNome());
        docData.put("cpf", medico.getCpf());
        docData.put("dataNascimento", medico.getDataNascimento());
        docData.put("cro", medico.getCRO());
        docData.put("especialidade", medico.getEspecialidade());
        docData.put("email", medico.getEmail());
        docData.put("senha", medico.getSenha());
        docData.put("celular", medico.getCelular());
        return docData;
    }
}