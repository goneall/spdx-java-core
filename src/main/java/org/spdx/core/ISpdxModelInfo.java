/**
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) 2024 Source Auditor Inc.
 */
package org.spdx.core;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.spdx.storage.IModelStore;

/**
 * @author Gary O'Neall
 * 
 * Interface for SPDX model information
 *
 */
public interface ISpdxModelInfo {
	
	/**
	 * @return a map of URIs to Enums which represents individual vocabularies in the SPDX model
	 */
	public Map<String, Enum<?>> getUriToEnumMap();

	/**
	 * @return the spec versions this model supports
	 */
	public List<String> getSpecVersions();

	/**
	 * @param store store to use for the inflated object
	 * @param uri URI of the external element
	 * @param copyManager if non-null, implicitly copy any referenced properties from other model stores
	 * @param documentUri URI for the SPDX document to store the external element reference - used for compatibility with SPDX 2.X model stores
	 * @param copyManager if non-null, create the external Doc ref if it is not a property of the SPDX Document
	 * @param externalMap Map of URI's of elements referenced but not present in the store
	 * @param specVersion version of the SPDX specification used by the external element
	 * @return model object of type type
	 */
	public CoreModelObject createExternalElement(IModelStore store, String uri,
			@Nullable IModelCopyManager copyManager,String specVersion) throws InvalidSPDXAnalysisException;

	/**
	 * @return a map of URIs to Individuals which represents individuals in the SPDX model
	 */
	public Map<String, Object> getUriToIndividualMap();

	/**
	 * @param modelStore store to use for the inflated object
	 * @param objectUri URI of the external element
	 * @param documentUri URI for the SPDX document to store the external element reference - used for compatibility with SPDX 2.X model stores
	 * @param type Type of the object to create
	 * @param copyManager if non-null, implicitly copy any referenced properties from other model stores
	 * @param specVersion version of the SPDX specification used by the model object
	 * @param create if true, create the model object ONLY if it does not already exist
	 * @return fully inflated model object of type type
	 */
	public CoreModelObject createModelObject(IModelStore modelStore,
			String objectUri, String type, IModelCopyManager copyManager,
			String specVersion, boolean create) throws InvalidSPDXAnalysisException;

	/**
	 * @return a map of string representation of types to classes which implement those types
	 */
	public Map<String, Class<?>> getTypeToClassMap();

}