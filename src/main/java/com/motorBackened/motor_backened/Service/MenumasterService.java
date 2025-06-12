package com.motorBackened.motor_backened.Service;

import java.util.List;

import com.motorBackened.motor_backened.request.MenuMasterRequest;
import com.motorBackened.motor_backened.response.MenuMasterResponse;

public interface MenumasterService 
{

	MenuMasterResponse addMenu(MenuMasterRequest request);

	MenuMasterResponse updateMenu(Long id, MenuMasterRequest request);

	List<MenuMasterResponse> getAllMenus();

	MenuMasterResponse getMenuById(Long id);


}
