package dev.peev.pastebox.web.controllers;

import static dev.peev.pastebox.test.utils.ModelFactory.createModel;
import static dev.peev.pastebox.test.utils.ModelTestConstants.CONTENT;
import static dev.peev.pastebox.test.utils.ModelTestConstants.CREATED_ON;
import static dev.peev.pastebox.test.utils.ModelTestConstants.ID;
import static dev.peev.pastebox.test.utils.ModelTestConstants.TITLE;
import static dev.peev.pastebox.web.controllers.constants.ViewConstants.PASTE_SHARE_VIEW;
import static java.time.LocalDateTime.parse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.peev.pastebox.domain.model.request.PasteRequestModel;
import dev.peev.pastebox.domain.model.response.PasteResponseModel;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.service.interfaces.PasteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class PasteControllerTest {
  @InjectMocks private PasteController pasteController;

  @Mock private PasteService pasteServiceMock;

  @Mock private ModelMapper modelMapperMock;

  @Mock private ModelAndView modelAndViewMock;

  private static final PasteServiceModel PASTE_SERVICE_MODEL = createModel(PasteServiceModel.class);

  private static final PasteResponseModel PASTE_RESPONSE_MODEL =
      createModel(PasteResponseModel.class);

  private static final PasteRequestModel PASTE_REQUEST_MODEL = createModel(PasteRequestModel.class);

  @Before
  public void setUp() {
    when(pasteServiceMock.findById(ID)).thenReturn(PASTE_SERVICE_MODEL);
    when(modelMapperMock.map(PASTE_SERVICE_MODEL, PasteResponseModel.class))
        .thenReturn(PASTE_RESPONSE_MODEL);
    when(modelMapperMock.map(PASTE_REQUEST_MODEL, PasteServiceModel.class))
        .thenReturn(PASTE_SERVICE_MODEL);
    when(pasteServiceMock.save(PASTE_SERVICE_MODEL)).thenReturn(PASTE_SERVICE_MODEL);
  }

  @Test
  public void testSubmitPaste() {
    assertPasteResponseModelFields(pasteController.submitPaste(PASTE_REQUEST_MODEL));
  }

  @Test
  public void testFetchPaste() {
    assertPasteResponseModelFields(pasteController.fetchPaste(ID));
  }

  @Test
  public void testSharePasteRendersCorrectView() {
    pasteController.sharePaste(modelAndViewMock);

    verify(modelAndViewMock).setViewName(PASTE_SHARE_VIEW);
  }

  private void assertPasteResponseModelFields(final PasteResponseModel pasteResponseModel) {
    assertThat(pasteResponseModel.getContent(), equalTo(CONTENT));
    assertThat(pasteResponseModel.getCreatedOn(), equalTo(parse(CREATED_ON)));
    assertThat(pasteResponseModel.getId(), equalTo(ID));
    assertThat(pasteResponseModel.getTitle(), equalTo(TITLE));
  }
}
