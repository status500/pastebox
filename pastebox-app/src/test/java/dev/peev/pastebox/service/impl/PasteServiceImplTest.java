package dev.peev.pastebox.service.impl;

import static dev.peev.pastebox.test.utils.ModelFactory.createModel;
import static dev.peev.pastebox.test.utils.ModelTestConstants.CONTENT;
import static dev.peev.pastebox.test.utils.ModelTestConstants.CREATED_ON;
import static dev.peev.pastebox.test.utils.ModelTestConstants.ID;
import static dev.peev.pastebox.test.utils.ModelTestConstants.TITLE;
import static java.time.LocalDateTime.parse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import dev.peev.pastebox.domain.entities.Paste;
import dev.peev.pastebox.domain.model.service.PasteServiceModel;
import dev.peev.pastebox.repository.PasteRepository;
import dev.peev.pastebox.service.interfaces.LocalDateTimeService;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class PasteServiceImplTest {
  private static final String INVALID_ID = "invalidId";

  @InjectMocks private PasteServiceImpl pasteService;

  @Mock private PasteRepository pasteRepositoryMock;

  @Mock private ModelMapper modelMapperMock;

  @Mock private LocalDateTimeService localDateTimeServiceMock;

  private static final PasteServiceModel PASTE_SERVICE_MODEL = createModel(PasteServiceModel.class);

  private static final Paste PASTE = createModel(Paste.class);

  @Before
  public void setUp() {
    when(pasteRepositoryMock.findById(ID)).thenReturn(Optional.of(PASTE));
    when(modelMapperMock.map(PASTE, PasteServiceModel.class)).thenReturn(PASTE_SERVICE_MODEL);
    when(modelMapperMock.map(PASTE_SERVICE_MODEL, Paste.class)).thenReturn(PASTE);
    when(localDateTimeServiceMock.now()).thenReturn(parse(CREATED_ON));
    when(pasteRepositoryMock.saveAndFlush(PASTE)).thenReturn(PASTE);
  }

  @Test
  public void testSavePersistsPasteServiceModelCorrectly() {
    assertPasteServiceModelFields(pasteService.save(PASTE_SERVICE_MODEL));
  }

  @Test(expected = NoSuchElementException.class)
  public void testFindByIdThrowsExceptionBecauseOfInvalidId() {
    pasteService.findById(INVALID_ID);
  }

  @Test
  public void testFindByIdReturnsCorrectPasteServiceModel() {
    assertPasteServiceModelFields(pasteService.findById(ID));
  }

  private void assertPasteServiceModelFields(final PasteServiceModel pasteServiceModel) {
    assertThat(pasteServiceModel.getId(), equalTo(ID));
    assertThat(pasteServiceModel.getTitle(), equalTo(TITLE));
    assertThat(pasteServiceModel.getContent(), equalTo(CONTENT));
    assertThat(pasteServiceModel.getCreatedOn(), equalTo(parse(CREATED_ON)));
  }
}
