package dev.peev.pastebox.test.utils;

import static dev.peev.pastebox.test.utils.ModelTestConstants.CONTENT;
import static dev.peev.pastebox.test.utils.ModelTestConstants.CREATED_ON;
import static dev.peev.pastebox.test.utils.ModelTestConstants.ID;
import static dev.peev.pastebox.test.utils.ModelTestConstants.TITLE;
import static java.time.LocalDateTime.parse;

import dev.peev.pastebox.domain.entities.Paste;
import dev.peev.pastebox.domain.model.request.PasteRequestModel;
import dev.peev.pastebox.domain.model.response.PasteResponseModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;

public class ModelFactory {
  public static <T> T createModel(final Class<T> modelClass) {
    final T genericModel;
    try {
      genericModel = modelClass.newInstance();

      if (modelClass.isAssignableFrom(PasteServiceModel.class)) {
        final PasteServiceModel pasteServiceModel = PasteServiceModel.class.cast(genericModel);

        pasteServiceModel.setContent(CONTENT);
        pasteServiceModel.setCreatedOn(parse(CREATED_ON));
        pasteServiceModel.setId(ID);
        pasteServiceModel.setTitle(TITLE);
      } else if (modelClass.isAssignableFrom(PasteResponseModel.class)) {
        final PasteResponseModel pasteResponseModel = PasteResponseModel.class.cast(genericModel);

        pasteResponseModel.setContent(CONTENT);
        pasteResponseModel.setCreatedOn(parse(CREATED_ON));
        pasteResponseModel.setId(ID);
        pasteResponseModel.setTitle(TITLE);
      } else if (modelClass.isAssignableFrom(PasteRequestModel.class)) {
        final PasteRequestModel pasteRequestModel = PasteRequestModel.class.cast(genericModel);

        pasteRequestModel.setContent(CONTENT);
        pasteRequestModel.setTitle(TITLE);
      } else if (modelClass.isAssignableFrom(Paste.class)) {
        final Paste paste = Paste.class.cast(genericModel);

        paste.setContent(CONTENT);
        paste.setCreatedOn(parse(CREATED_ON));
        paste.setId(ID);
        paste.setTitle(TITLE);
      } else {
        throw new Exception("Invalid model specified! Requested model is: " + modelClass);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalStateException("Unable to generate and populate test model instance!");
    }

    return genericModel;
  }
}
