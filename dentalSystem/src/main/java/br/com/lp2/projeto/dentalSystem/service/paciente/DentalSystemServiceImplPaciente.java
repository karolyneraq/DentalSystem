package br.com.lp2.projeto.dentalSystem.service.paciente;

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

import br.com.lp2.projeto.dentalSystem.dto.PacienteDTO;
import br.com.lp2.projeto.dentalSystem.firebase.FirebaseInitializer;

@Service
public class DentalSystemServiceImplPaciente implements DentalSystemServicePaciente {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<PacienteDTO> list() {
        List<PacienteDTO> response = new ArrayList<>();
        PacienteDTO paciente;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
            	paciente = doc.toObject(PacienteDTO.class);
            	paciente.setId(doc.getId());
                response.add(paciente);
            }
            return response;
        } catch (Exception e) {
            return null;
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
    public Boolean add(PacienteDTO paciente) {
    	
        Map<String, Object> docData = getDocData(paciente);											// Vai criar um mapa para armazenar os dados do paciente
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);  // Vai adicionar um novo documento (de forma assíncrona) na coleção do getCollection com id

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
    public Boolean edit(String id, PacienteDTO paciente) {
        Map<String, Object> docData = getDocData(paciente);
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
        return firebase.getFirestore().collection("paciente");
    }

    private Map<String, Object> getDocData(PacienteDTO paciente) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("nome", paciente.getNome());
        docData.put("cpf", paciente.getCpf());
        docData.put("rg", paciente.getRg());
        docData.put("dataNascimento", paciente.getDataNascimento());
        docData.put("sexo", paciente.getSexo());
        docData.put("celular", paciente.getCelular());
        docData.put("numero", paciente.getNumero());
        return docData;
    }
}