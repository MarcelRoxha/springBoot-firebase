package com.example.teste.firebase.teste.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {

    public String createCRUD(CRUD crud) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletions = dbFirestore.collection("crud_user").document(crud.getName()).set(crud);

        return colletions.get().getUpdateTime().toString();
    }

    public String updateCRUD(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletions = dbFirestore.collection("crud_user").document(crud.getDocument_id()).set(crud);

        return colletions.get().getUpdateTime().toString();
    }

    public CRUD getCRUD( String document_id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("crud_user").document(document_id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapsho = future.get();
        CRUD crud;
        if(documentSnapsho.exists()){
            crud = documentSnapsho.toObject(CRUD.class);
            return  crud;
        }
        return null;
    }
    public String deleteCRUD(String document_id){

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = dbFirestore.collection("crud_user").document(document_id).delete();
        return  "Sucessfully deletd" + document_id;
    }
}
