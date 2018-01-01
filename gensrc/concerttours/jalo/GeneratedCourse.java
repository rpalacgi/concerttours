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
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Course}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCourse extends GenericItem
{
	/** Qualifier of the <code>Course.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Course.cname</code> attribute **/
	public static final String CNAME = "cname";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(CNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Course.cname</code> attribute.
	 * @return the cname - short unique code of band
	 */
	public String getCname(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Course.cname</code> attribute.
	 * @return the cname - short unique code of band
	 */
	public String getCname()
	{
		return getCname( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Course.cname</code> attribute. 
	 * @param value the cname - short unique code of band
	 */
	public void setCname(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Course.cname</code> attribute. 
	 * @param value the cname - short unique code of band
	 */
	public void setCname(final String value)
	{
		setCname( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Course.code</code> attribute.
	 * @return the code - history of band
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Course.code</code> attribute.
	 * @return the code - history of band
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Course.code</code> attribute. 
	 * @param value the code - history of band
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Course.code</code> attribute. 
	 * @param value the code - history of band
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
}
