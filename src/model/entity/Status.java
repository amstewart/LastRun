
package model.entity;

/**
 *
 * @author ChrisMoscoso
 */
public enum Status {
	SLEEPING(1),
	INVISIBLE(2),
	MOUNTED(3)
	;
	int status;

	private Status(int status) {
		status = status;
	}
}
