/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outgoingexception.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.outgoingexception.OutgoingExceptionConfig;
import org.openmrs.module.outgoingexception.OutgoingMessage;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface OutgoingExceptionService extends OpenmrsService {
	
	/**
	 * Returns an item by uuid. It can be called by any authenticated user. It is fetched in read
	 * only transaction.
	 * 
	 * @param uuid
	 * @return
	 * @throws APIException
	 */
	@Authorized()
	@Transactional(readOnly = true)
	OutgoingMessage getItemByUuid(String uuid) throws APIException;
	
	/**
	 * Saves an outgoingMessage. Sets the owner to superuser, if it is not set. It can be called by
	 * users with this module's privilege. It is executed in a transaction.
	 * 
	 * @param outgoingMessage
	 * @return
	 * @throws APIException
	 */
	@Authorized(OutgoingExceptionConfig.MODULE_PRIVILEGE)
	@Transactional
	OutgoingMessage saveItem(OutgoingMessage outgoingMessage) throws APIException;
}