package br.com.trainning.pdv2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mapzen.android.lost.api.LocationServices;
import com.mapzen.android.lost.api.LostApiClient;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import br.com.trainning.pdv2.R;
import br.com.trainning.pdv2.domain.ImageInputHelper;
import br.com.trainning.pdv2.domain.model.Produto;
import butterknife.Bind;
import butterknife.OnClick;

public class CadastroNovoActivity extends BaseActivity implements ImageInputHelper.ImageActionListener {

    private ImageInputHelper imageInputHelper;
    private Produto produto;
    private double latidude = 0.0d;
    private double longitude = 0.0d;

    @Bind(R.id.editTextDescricao)
    EditText editTextDescricao;
    @Bind(R.id.editTextUnidade)
    EditText editTextUnidade;
    @Bind(R.id.editTextPreco)
    EditText editTextPreco;
    @Bind(R.id.editTextCodigoBarras)
    EditText editTextCodigoBarras;

    @Bind(R.id.imageViewFoto)
    ImageView imageViewFoto;
    @Bind(R.id.imageButtonCamera)
    ImageButton imageButtonCamera;
    @Bind(R.id.imageButtonGaleria)
    ImageButton imageButtonGaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Na versão do android 6 para cima precisa lançar um PopUp confirmando
        //a utilização da sua localização.
        //LostApiClient lostApiClient = new LostApiClient.Builder(this).build();
        //lostApiClient.connect();

        //Location location = LocationServices.FusedLocationApi.getLastLocation();
        //if (location != null) {
            //latidude = location.getLatitude();
            //longitude = location.getLongitude();
        //}

        Log.d("LOCALIZAÇÃO", "Latidude:" + latidude);
        Log.d("LOCALIZAÇÃO", "Longitude:" + longitude);

        imageInputHelper = new ImageInputHelper(this);
        imageInputHelper.setImageActionListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Cadastro", editTextDescricao.getText().toString());
                Log.d("Cadastro", editTextUnidade.getText().toString());
                Log.d("Cadastro", editTextPreco.getText().toString());
                Log.d("Cadastro", editTextCodigoBarras.getText().toString());

                produto = new Produto();
                produto.setId(0);
                produto.setDescricao(editTextDescricao.getText().toString());
                produto.setUnidade(editTextUnidade.getText().toString());
                produto.setCodigoBarras(editTextCodigoBarras.getText().toString());

                if (!editTextPreco.getText().toString().equals(""))
                {
                    produto.setPreco(Double.parseDouble(editTextPreco.getText().toString()));
                }
                else
                {
                    produto.setPreco(0.0);
                }

                Bitmap imagem = ((BitmapDrawable)imageViewFoto.getDrawable()).getBitmap();
                produto.setFoto(Base64Util.encodeTobase64(imagem));
                produto.setLatitude(latidude);
                produto.setLongitude(longitude);
                produto.save();
                Log.d("Gravar", "Gravado com sucesso");
                finish();
            }
        });
    }

    @OnClick(R.id.imageButtonGaleria)
    public void onClickGaleria()
    {
        imageInputHelper.selectImageFromGallery();
    }

    @OnClick(R.id.imageButtonCamera)
    public void onClickCamera()
    {
        imageInputHelper.takePhotoWithCamera();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageInputHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onImageSelectedFromGallery(Uri uri, File imageFile) {
        imageInputHelper.requestCropImage(uri, 100, 100, 0, 0);
    }

    @Override
    public void onImageTakenFromCamera(Uri uri, File imageFile) {
        imageInputHelper.requestCropImage(uri, 100, 100, 0, 0);
    }

    @Override
    public void onImageCropped(Uri uri, File imageFile) {
        try {
            // getting bitmap from uri
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            imageViewFoto.setImageBitmap(bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
