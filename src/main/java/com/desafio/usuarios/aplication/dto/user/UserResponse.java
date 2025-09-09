package com.desafio.usuarios.aplication.dto.user;


import com.desafio.usuarios.domain.pageable.Pagination;

public class UserResponse <T>{
    private T data;
    private Pagination pagination;
    private String error;


    public UserResponse(T data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public UserResponse(String error){
        this.error = error;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}