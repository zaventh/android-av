package com.steelthorn.android.av;

/**
 * Represents a single definition or signature of a known malicious package,
 * program, file, or other data structure. Each IScanDefinition is inert; that
 * is, the definitions themselves do not do the matching. They must be provided
 * to an <code>IScanEngine</code> which determines the scanning and matching
 * algorithms.
 * 
 * @author Jeff Mixon
 * @see IScanDefinitionGroup
 */
public interface IScanDefinition
{
	/**
	 * Uniquely identifies a definition
	 * 
	 * @return the unique identifier for the definition
	 */
	int getDefinitionId();

	/**
	 * Gets the hashed bytes of the virus signature this definition represents.
	 * 
	 * @return the hashed signature
	 */
	byte[] getHashValue();

	/**
	 * Gets the size of the non-hashed bytes that create a match. This can be
	 * used for optimizing the definitions you need to search on without having
	 * to do other calculations
	 * 
	 * @return the size of the non-hashed matching portion
	 */
	int getMatchSize();

	/**
	 * Gets the contextual position of where this definition's signature is
	 * found.
	 * 
	 * @return the position in the source that this definition would be found
	 */
	long getMatchPosition();

	/**
	 * Get the match weight of this definition. This can be either positive or
	 * negative to have the necessary effect on the overall scoring of a target
	 * against several definitions. This only applies to
	 * <code>IScanDefinitionGroup</code>s which contain multiple
	 * <code>IScanDefinition</code>s.
	 * 
	 * @return the match weight
	 * @see IScanDefinitionGroup
	 */
	double getWeight();
}
