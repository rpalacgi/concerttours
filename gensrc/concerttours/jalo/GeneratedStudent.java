/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 29, 2017 1:11:37 AM                     ---
 * ----------------------------------------------------------------
 */
package concerttours.jalo;

import concerttours.constants.ConcerttoursConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Student}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedStudent extends GenericItem
{
	/** Qualifier of the <code>Student.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Student.fname</code> attribute **/
	public static final String FNAME = "fname";
	/** Qualifier of the <code>Student.lname</code> attribute **/
	public static final String LNAME = "lname";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(FNAME, AttributeMode.INITIAL);
		tmp.put(LNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.code</code> attribute.
	 * @return the code - short unique code of band
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.code</code> attribute.
	 * @return the code - short unique code of band
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.code</code> attribute. 
	 * @param value the code - short unique code of band
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.code</code> attribute. 
	 * @param value the code - short unique code of band
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.fname</code> attribute.
	 * @return the fname - short unique code of band
	 */
	public String getFname(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.fname</code> attribute.
	 * @return the fname - short unique code of band
	 */
	public String getFname()
	{
		return getFname( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.fname</code> attribute. 
	 * @param value the fname - short unique code of band
	 */
	public void setFname(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.fname</code> attribute. 
	 * @param value the fname - short unique code of band
	 */
	public void setFname(final String value)
	{
		setFname( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.lname</code> attribute.
	 * @return the lname - name of band
	 */
	public String getLname(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Student.lname</code> attribute.
	 * @return the lname - name of band
	 */
	public String getLname()
	{
		return getLname( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.lname</code> attribute. 
	 * @param value the lname - name of band
	 */
	public void setLname(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Student.lname</code> attribute. 
	 * @param value the lname - name of band
	 */
	public void setLname(final String value)
	{
		setLname( getSession().getSessionContext(), value );
	}
	
}
