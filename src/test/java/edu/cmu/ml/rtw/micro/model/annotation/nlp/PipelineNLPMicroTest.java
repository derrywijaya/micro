package edu.cmu.ml.rtw.micro.model.annotation.nlp;

import java.util.List;

//import org.junit.Test;


import org.junit.Test;

import edu.cmu.ml.rtw.generic.data.annotation.nlp.DocumentNLP;
import edu.cmu.ml.rtw.generic.data.annotation.nlp.DocumentNLPInMemory;
import edu.cmu.ml.rtw.generic.data.annotation.nlp.Language;
import edu.cmu.ml.rtw.generic.data.annotation.nlp.micro.Annotation;
import edu.cmu.ml.rtw.generic.model.annotator.nlp.PipelineNLP;
import edu.cmu.ml.rtw.generic.model.annotator.nlp.PipelineNLPStanford;
import edu.cmu.ml.rtw.micro.data.MicroDataTools;

public class PipelineNLPMicroTest {
	@Test
	public void testDocument() {
		PipelineNLPStanford stanfordPipe = new PipelineNLPStanford(30);
		PipelineNLPMicro microPipe = new PipelineNLPMicro();
		PipelineNLP stanfordMicroPipe = stanfordPipe.weld(microPipe);
		System.out.println("Annotating Test Document 1");
		DocumentNLP document = new DocumentNLPInMemory(new MicroDataTools(), 
			"Test document 1",
			"I baked a cake in the oven.  Barack Obama helped because I was " +
	  	   	"the deciding vote in the next United States presidential election.",
			 Language.English, stanfordMicroPipe);

		List<Annotation> annotations = document.toMicroAnnotation().getAllAnnotations();
		for (Annotation annotation : annotations)
			System.out.println(annotation.toJsonString());


		System.out.println("Annotating Test Document 2");
		document = new DocumentNLPInMemory(new MicroDataTools(), 
			"Test document 2",
			"Ernest Hemingway was born in the United States in 1899.",
			 Language.English, stanfordMicroPipe);

		annotations = document.toMicroAnnotation().getAllAnnotations();
		for (Annotation annotation : annotations)
			System.out.println(annotation.toJsonString());
		
	
	}
}
