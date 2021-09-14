package service;

import dto.PostDTO;

import java.util.List;
public interface DentalSystemService {

    List<PostDTO> list();

    Boolean add(PostDTO post);

    Boolean edit(String id,PostDTO post);

    Boolean delete(String id);


}