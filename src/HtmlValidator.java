import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> openTags = new Stack<>();

		for (HtmlTag tag : tags) {
			if(tag.isOpenTag()) {
				openTags.add(tag);
			} else if(!tag.isSelfClosing()) {
				if(!openTags.isEmpty() && openTags.peek().matches(tag)) {
					openTags.pop();
				} else {
					if(openTags.isEmpty()) openTags.push(tag);
					break;
				}
			}
		}

		if(!openTags.isEmpty() && !openTags.peek().isOpenTag()) return null;

		return openTags; // this line is here only so this code will compile if you don't modify it
	}
}

